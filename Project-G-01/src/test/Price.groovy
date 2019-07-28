package test


class Price {
    static Map<String, String> margins;
    static def categories;
    static def products;

    static {
        margins = [
                "C1" : "20%",
                "C2" : "30%",
                "C3" : "0.4",
                "C4" : "50%",
                "C5" : "0.6"]

        categories = [
                ["C3", 50, 75],
                ["C4", 75, 100],
                ["C2", 25, 50],
                ["C5", 100, null],
                ["C1", 0, 25]]


        products = [
                ["A", "G1", 20.1],
                ["B", "G2", 98.4],
                ["C", "G1", 49.7],
                ["D", "G3", 35.8],
                ["E", "G3", 105.5],
                ["F", "G1", 55.2],
                ["G", "G1", 12.7],
                ["H", "G3", 88.6],
                ["I", "G1", 5.2],
                ["J", "G2", 72.4]]
    }

    static void main(String[] args) {
        def getPrice =  { cost ->
            def category = categories.find { c ->
                return c[1] <= cost && (c[2] == null || cost < c[2])
            }
            def margin = margins.get(category[0])
            return String.valueOf(margin).contains("%") ? cost + ((cost * Double.parseDouble(margin.replace("%", ""))) /100)
                    :  cost * (1 + Double.parseDouble(margin));
        }

        Map<String, List<Double>> costsOfGroup = [:]
        products.each {
            Double price = getPrice(it[2])
            if (costsOfGroup.containsKey(it[1])) {
                costsOfGroup.get(it[1]).add(price)
            } else {
                costsOfGroup.put(it[1],[price])
            }
        }

        def result = costsOfGroup.inject([:]){ r, k, v ->
            r[k] = ((Double)v.sum() / v.size()).round(1)
            r
        }

        assert result == [
                "G1" : 37.5,
                "G2" : 124.5,
                "G3" : 116.1
        ]  : "It doesn't work"

        println("It works!")
    }
}

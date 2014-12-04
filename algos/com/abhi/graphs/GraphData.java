package com.abhi.graphs;

import com.sun.deploy.util.StringUtils;

import java.util.*;

/**
 * Created by abhishek on 9/24/14.
 */
public class GraphData {

    static SearchSpace romania;
    static SearchSpace USA;

    public SearchSpace getRomaniaSearchSpace(){
        if(romania == null){
            initRomania();
        }
        return romania;
    }

    public SearchSpace getUSASearchSpace(){
        if(USA == null){
            initUSA();
        }
        return USA;
    }

    private static void initRomania() {

        Map<String,Node> nodes = new LinkedHashMap<String, Node>();

        Node oradea = new Node("oradea");
        Map<String, Integer> link1 = new LinkedHashMap<String, Integer>();
        link1.put("sibiu",151); link1.put("zerind",71);
        oradea.setLink(link1);
        nodes.put("oradea", oradea);

        Node zerind = new Node("zerind");
        Map<String, Integer> link2 = new LinkedHashMap<String, Integer>();
        link2.put("arad",75); link2.put("oradea",71);
        zerind.setLink(link2);
        nodes.put("zerind", zerind);

        Node arad = new Node("arad");
        Map<String, Integer> link3 = new LinkedHashMap<String, Integer>();
        link3.put("sibiu",140); link3.put("timisoara",118);link3.put("zerind",75);
        arad.setLink(link3);
        nodes.put("arad", arad);

        Node timisoara = new Node("timisoara");
        Map<String, Integer> link4 = new LinkedHashMap<String, Integer>();
        link4.put("arad",118); link4.put("lugoj",111);
        timisoara.setLink(link4);
        nodes.put("timisoara", timisoara);

        Node lugoj = new Node("lugoj");
        Map<String, Integer> link5 = new LinkedHashMap<String, Integer>();
        link5.put("mehadia",70); link5.put("timisoara",111);
        lugoj.setLink(link5);
        nodes.put("lugoj", lugoj);

        Node mehadia = new Node("mehadia");
        Map<String, Integer> link6 = new LinkedHashMap<String, Integer>();
        link6.put("dobreta",75); link6.put("lugoj",70);
        mehadia.setLink(link6);
        nodes.put("mehadia", mehadia);

        Node dobreta = new Node("dobreta");
        Map<String, Integer> link7 = new LinkedHashMap<String, Integer>();
        link7.put("craiova",120); link7.put("mehadia",75);
        dobreta.setLink(link7);
        nodes.put("dobreta", dobreta);

        Node craiova = new Node("craiova");
        Map<String, Integer> link8 = new LinkedHashMap<String, Integer>();
        link8.put("dobreta",120); link8.put("pitesti",138); link8.put("rimnicu_vilcea",146);
        craiova.setLink(link8);
        nodes.put("craiova", craiova);

        Node rimnicu_vilcea = new Node("rimnicu_vilcea");
        Map<String, Integer> link9 = new LinkedHashMap<String, Integer>();
        link9.put("craiova",146); link9.put("pitesti",97); link9.put("sibiu",80);
        rimnicu_vilcea.setLink(link9);
        nodes.put("rimnicu_vilcea", rimnicu_vilcea);

        Node sibiu = new Node("sibiu");
        Map<String, Integer> link10 = new LinkedHashMap<String, Integer>();
        link10.put("arad",140); link10.put("fagaras",99); link10.put("oradea",151); link10.put("rimnicu_vilcea",80);
        sibiu.setLink(link10);
        nodes.put("sibiu", sibiu);

        Node fagaras = new Node("fagaras");
        Map<String, Integer> link11 = new LinkedHashMap<String, Integer>();
        link11.put("bucharest",211); link11.put("sibiu",99);
        fagaras.setLink(link11);
        nodes.put("fagaras", fagaras);

        Node pitesti = new Node("pitesti");
        Map<String, Integer> link12 = new LinkedHashMap<String, Integer>();
        link12.put("bucharest",101); link12.put("craiova",138); link12.put("rimnicu_vilcea",97);
        pitesti.setLink(link12);
        nodes.put("pitesti", pitesti);

        Node bucharest = new Node("bucharest");
        Map<String, Integer> link13 = new LinkedHashMap<String, Integer>();
        link13.put("fagaras",211); link13.put("giurgiu",90); link13.put("pitesti",101);link13.put("urziceni",85);
        bucharest.setLink(link13);
        nodes.put("bucharest", bucharest);

        Node giurgiu = new Node("giurgiu");
        Map<String, Integer> link14 = new LinkedHashMap<String, Integer>();
        link14.put("bucharest",90);
        giurgiu.setLink(link14);
        nodes.put("giurgiu", giurgiu);

        Node neamt = new Node("neamt");
        Map<String, Integer> link15 = new LinkedHashMap<String, Integer>();
        link15.put("iasi",87);
        neamt.setLink(link15);
        nodes.put("neamt", neamt);

        Node iasi = new Node("iasi");
        Map<String, Integer> link16 = new LinkedHashMap<String, Integer>();
        link16.put("neamt",87);link16.put("vaslui",92);
        iasi.setLink(link16);
        nodes.put("iasi", iasi);

        Node vaslui = new Node("vaslui");
        Map<String, Integer> link17 = new LinkedHashMap<String, Integer>();
        link17.put("iasi",92);link17.put("urziceni",142);
        vaslui.setLink(link17);
        nodes.put("vaslui", vaslui);

        Node urziceni = new Node("urziceni");
        Map<String, Integer> link18 = new LinkedHashMap<String, Integer>();
        link18.put("bucharest",85);  link18.put("hirsova",98);link18.put("vaslui",142);
        urziceni.setLink(link18);
        nodes.put("urziceni", urziceni);

        Node hirsova = new Node("hirsova");
        Map<String, Integer> link19 = new LinkedHashMap<String, Integer>();
        link19.put("eforie",86); link19.put("urziceni",98);
        hirsova.setLink(link19);
        nodes.put("hirsova", hirsova);

        Node eforie = new Node("eforie");
        Map<String, Integer> link20 = new LinkedHashMap<String, Integer>();
        link20.put("hirsova",86);
        eforie.setLink(link20);
        nodes.put("eforie", eforie);

        romania = new SearchSpace(nodes);
    }

    private void initUSA() {

        Map<String,Node> nodes = new LinkedHashMap<String, Node>();
        List<City> cities = getCityPositions();
        for(City city : cities){

            Node node = new Node(city.name);
            node.setLatitude(city.latitude);
            node.setLongitude(city.longitude);
            Map<String, Integer> link = new HashMap<String, Integer>();
            node.setLink(link);
            nodes.put(node.getName(), node);
        }

        List<CityMap> cityMapList = getCityMap();
        for(CityMap cityMap : cityMapList){

            Node nodeCity = nodes.get(cityMap.city1);
            Map<String, Integer> link = nodeCity.getLink();

            link.put(cityMap.city2, cityMap.distance);
        }

        USA = new SearchSpace(nodes);
    }

    public class City{
        String name;
        float latitude;
        float longitude;

        @Override
        public String toString() {
            return "City{" +
                    "name=" + name +
                    ", latitude=" + latitude +
                    ", longitude=" + longitude +
                    '}';
        }
    }

    private List<City> getCityPositions() {

        List<City> cities = new LinkedList<City>();
        String cityPositionStr = "city(albanyGA,        31.58,  84.17). city(albanyNY,        42.66,  73.78). city(albuquerque,     35.11, 106.61). city(atlanta,         33.76,  84.40). city(augusta,         33.43,  82.02). city(austin,          30.30,  97.75). city(bakersfield,     35.36, 119.03). city(baltimore,       39.31,  76.62). city(batonRouge,      30.46,  91.14). city(beaumont,        30.08,  94.13). city(boise,           43.61, 116.24). city(boston,          42.32,  71.09). city(buffalo,         42.90,  78.85). city(calgary,         51.00, 114.00). city(charlotte,       35.21,  80.83). city(chattanooga,     35.05,  85.27). city(chicago,         41.84,  87.68). city(cincinnati,      39.14,  84.50). city(cleveland,       41.48,  81.67). city(coloradoSprings, 38.86, 104.79). city(columbus,        39.99,  82.99). city(dallas,          32.80,  96.79). city(dayton,          39.76,  84.20). city(daytonaBeach,    29.21,  81.04). city(denver,          39.73, 104.97). city(desMoines,       41.59,  93.62). city(elPaso,          31.79, 106.42). city(eugene,          44.06, 123.11). city(europe,          48.87,  -2.33). city(ftWorth,         32.74,  97.33). city(fresno,          36.78, 119.79). city(grandJunction,   39.08, 108.56). city(greenBay,        44.51,  88.02). city(greensboro,      36.08,  79.82). city(houston,         29.76,  95.38). city(indianapolis,    39.79,  86.15). city(jacksonville,    30.32,  81.66). city(japan,           35.68, 220.23). city(kansasCity,      39.08,  94.56). city(keyWest,         24.56,  81.78). city(lafayette,       30.21,  92.03). city(lakeCity,        30.19,  82.64). city(laredo,          27.52,  99.49). city(lasVegas,        36.19, 115.22). city(lincoln,         40.81,  96.68). city(littleRock,      34.74,  92.33). city(losAngeles,      34.03, 118.17). city(macon,           32.83,  83.65). city(medford,         42.33, 122.86). city(memphis,         35.12,  89.97). city(mexia,           31.68,  96.48). city(mexico,          19.40,  99.12). city(miami,           25.79,  80.22). city(midland,         43.62,  84.23). city(milwaukee,       43.05,  87.96). city(minneapolis,     44.96,  93.27). city(modesto,         37.66, 120.99). city(montreal,        45.50,  73.67). city(nashville,       36.15,  86.76). city(newHaven,        41.31,  72.92). city(newOrleans,      29.97,  90.06). city(newYork,         40.70,  73.92). city(norfolk,         36.89,  76.26). city(oakland,         37.80, 122.23). city(oklahomaCity,    35.48,  97.53). city(omaha,           41.26,  96.01). city(orlando,         28.53,  81.38). city(ottawa,          45.42,  75.69). city(pensacola,       30.44,  87.21). city(philadelphia,    40.72,  76.12). city(phoenix,         33.53, 112.08). city(pittsburgh,      40.40,  79.84). city(pointReyes,      38.07, 122.81). city(portland,        45.52, 122.64). city(providence,      41.80,  71.36). city(provo,           40.24, 111.66). city(raleigh,         35.82,  78.64). city(redding,         40.58, 122.37). city(reno,            39.53, 119.82). city(richmond,        37.54,  77.46). city(rochester,       43.17,  77.61). city(sacramento,      38.56, 121.47). city(salem,           44.93, 123.03). city(salinas,         36.68, 121.64). city(saltLakeCity,    40.75, 111.89). city(sanAntonio,      29.45,  98.51). city(sanDiego,        32.78, 117.15). city(sanFrancisco,    37.76, 122.44). city(sanJose,         37.30, 121.87). city(sanLuisObispo,   35.27, 120.66). city(santaFe,         35.67, 105.96). city(saultSteMarie,   46.49,  84.35). city(savannah,        32.05,  81.10). city(seattle,         47.63, 122.33). city(stLouis,         38.63,  90.24). city(stamford,        41.07,  73.54). city(stockton,        37.98, 121.30). city(tallahassee,     30.45,  84.27). city(tampa,           27.97,  82.46). city(thunderBay,      48.38,  89.25). city(toledo,          41.67,  83.58). city(toronto,         43.65,  79.38). city(tucson,          32.21, 110.92). city(tulsa,           36.13,  95.94). city(uk1,             51.30,   0.00). city(uk2,             51.30,   0.00). city(vancouver,       49.25, 123.10). city(washington,      38.91,  77.01). city(westPalmBeach,   26.71,  80.05). city(wichita,         37.69,  97.34). city(winnipeg,        49.90,  97.13). city(yuma,            32.69, 114.62).";
        cityPositionStr = cityPositionStr.trim();
        String[] split1 =  cityPositionStr.split("\\).");

        for(String str : split1){

            str = str.trim().substring(5);
            String[] split2 = str.split(",");

            City city = new City();
            city.name = split2[0].trim();
            city.latitude = Float.valueOf(split2[1].trim());
            city.longitude = Float.valueOf(split2[2].trim());

            cities.add(city);
        }
        return cities;
    }

    class CityMap{
        String city1;
        String city2;
        int distance;
    }

    private List<CityMap> getCityMap(){

        List<CityMap> cityMaps = new LinkedList<CityMap>();
        String cityMapStr = "road(albanyNY, montreal, 226). road(albanyNY, boston, 166). road(albanyNY, rochester, 148).   road(albanyGA, tallahassee, 120). road(albanyGA, macon, 106).   road(albuquerque, elPaso, 267).  road(albuquerque, santaFe, 61).   road(atlanta, macon, 82). road(atlanta, chattanooga, 117).   road(augusta, charlotte, 161).  road(augusta, savannah, 131).   road(austin, houston, 186).  road(austin, sanAntonio, 79).   road(bakersfield, losAngeles, 112).  road(bakersfield, fresno, 107).   road(baltimore, philadelphia, 102).  road(baltimore, washington, 45).   road(batonRouge, lafayette, 50).  road(batonRouge, newOrleans, 80).   road(beaumont, houston, 69).  road(beaumont, lafayette, 122).   road(boise, saltLakeCity, 349). road(boise, portland, 428).   road(boston, providence, 51).   road(buffalo, toronto, 105). road(buffalo, rochester, 64).  road(buffalo, cleveland, 191).   road(buffalo, toronto, 105). road(buffalo, rochester, 164).  road(buffalo, cleveland, 191).   road(calgary, vancouver, 605).  road(calgary, winnipeg, 829).   road(charlotte, greensboro, 91).   road(chattanooga, nashville, 129).   road(chicago, milwaukee, 90).  road(chicago, midland, 279).   road(cincinnati, indianapolis, 110).  road(cincinnati, dayton, 56).   road(cleveland, pittsburgh, 157).  road(cleveland, columbus, 142).   road(coloradoSprings, denver, 70).  road(coloradoSprings, santaFe, 316).   road(columbus, dayton, 72).   road(dallas, denver, 792).  road(dallas, mexia, 83).   road(daytonaBeach, jacksonville, 92).  road(daytonaBeach, orlando, 54).   road(denver, wichita, 523).  road(denver, grandJunction, 246).   road(desMoines, omaha, 135).  road(desMoines, minneapolis, 246).   road(elPaso, sanAntonio, 580). road(elPaso, tucson, 320).   road(eugene, salem, 63).  road(eugene, medford, 165).   road(europe, philadelphia, 3939).   road(ftWorth, oklahomaCity, 209).   road(fresno, modesto, 109).   road(grandJunction, provo, 220).   road(greenBay, minneapolis, 304). road(greenBay, milwaukee, 117).   road(greensboro, raleigh, 74).   road(houston, mexia, 165).   road(indianapolis, stLouis, 246).   road(jacksonville, savannah, 140).  road(jacksonville, lakeCity, 113).   road(japan, pointReyes, 5131).  road(japan, sanLuisObispo, 5451).   road(kansasCity, tulsa, 249).  road(kansasCity, stLouis, 256). road(kansasCity, wichita, 190).   road(keyWest, tampa, 446).   road(lakeCity, tampa, 169).  road(lakeCity, tallahassee, 104).   road(laredo, sanAntonio, 154). road(laredo, mexico, 741).   road(lasVegas, losAngeles, 275).  road(lasVegas, saltLakeCity, 486).   road(lincoln, wichita, 277).  road(lincoln, omaha, 58).   road(littleRock, memphis, 137). road(littleRock, tulsa, 276).   road(losAngeles, sanDiego, 124).  road(losAngeles, sanLuisObispo, 182).   road(medford, redding, 150).   road(memphis, nashville, 210).   road(miami, westPalmBeach, 67).   road(midland, toledo, 82).   road(minneapolis, winnipeg, 463).   road(modesto, stockton, 29).   road(montreal, ottawa, 132).   road(newHaven, providence, 110).  road(newHaven, stamford, 92).   road(newOrleans, pensacola, 268).   road(newYork, philadelphia, 101).   road(norfolk, richmond, 92).  road(norfolk, raleigh, 174).   road(oakland, sanFrancisco, 8). road(oakland, sanJose, 42).   road(oklahomaCity, tulsa, 105).   road(orlando, westPalmBeach, 168). road(orlando, tampa, 84).   road(ottawa, toronto, 269).   road(pensacola, tallahassee, 120).   road(philadelphia, pittsburgh, 319). road(philadelphia, newYork, 101). road(philadelphia, uk1, 3548).   road(philadelphia, uk2, 3548).   road(phoenix, tucson, 117).  road(phoenix, yuma, 178).   road(pointReyes, redding, 215).  road(pointReyes, sacramento, 115).   road(portland, seattle, 174).  road(portland, salem, 47).   road(reno, saltLakeCity, 520).  road(reno, sacramento, 133).   road(richmond, washington, 105).   road(sacramento, sanFrancisco, 95).  road(sacramento, stockton, 51).   road(salinas, sanJose, 31).  road(salinas, sanLuisObispo, 137).   road(sanDiego, yuma, 172).   road(saultSteMarie, thunderBay, 442).  road(saultSteMarie, toronto, 436).   road(seattle, vancouver, 115).   road(thunderBay, winnipeg, 440).";
        cityMapStr = cityMapStr.trim();
        String[] split1 =  cityMapStr.split("\\).");

        for(String str : split1){

            str = str.trim().substring(5);
            String[] split2 = str.split(",");

            CityMap cityMap1 = new CityMap();

            cityMap1.city1 = split2[0].trim();
            cityMap1.city2 = split2[1].trim();
            cityMap1.distance = Integer.valueOf(split2[2].trim());

            CityMap cityMap2 = new CityMap();
            cityMap2.city1 = split2[1].trim();
            cityMap2.city2 = split2[0].trim();
            cityMap2.distance = Integer.valueOf(split2[2].trim());

            cityMaps.add(cityMap1);
            cityMaps.add(cityMap2);
        }
        return cityMaps;
    }

}
(ns linq-clj.data
  (:require
    [ clojure.java.io :refer [ reader ] ]
    [ clojure.data.xml :refer [ parse ] ]
    [ clojure.zip :refer [ xml-zip ] ]
    [ clojure.data.zip.xml :refer [ xml-> xml1-> attr attr= text ] ]
    [ clj-time.format :as tmf ]))

(defn order->map [ order ]
  (let [ tf (tmf/formatters :date-hour-minute-second) ]
    { :id (Integer/parseInt (xml1-> order :id text))
      :date (tmf/parse tf (xml1-> order :orderdate text))
      :total (Double/parseDouble (xml1-> order :total text)) }))

(defn customer->map [ customer ]
  { :id (xml1-> customer :id text)
    :name (xml1-> customer :name text)
    :addres (xml1-> customer :address text)
    :city (xml1-> customer :city text)
    :postal-code (xml1-> customer :postalcode text)
    :country (xml1-> customer :country text)
    :phone (xml1-> customer :phone text)
    :fax (xml1-> customer :fax text)
    :orders (mapv order->map (xml-> customer :orders :order)) })

(defn import-customers [ file ]
  (let [ customers (-> file reader parse xml-zip) ]
    (for [ customer (xml-> customers :customer) ]
      (customer->map customer))))

(def customers (import-customers "resources/customers.xml"))

(def products
  [ { :id 1 :name "Chai" :category "Beverages" :price 18.0000 :in-stock 39 }
    { :id 2 :name "Chang" :category "Beverages" :price 19.0000 :in-stock 17 }
    { :id 3 :name "Aniseed Syrup" :category "Condiments" :price 10.0000 :in-stock 13 }
    { :id 4 :name "Chef Anton's Cajun Seasoning" :category "Condiments" :price 22.0000 :in-stock 53 }
    { :id 5 :name "Chef Anton's Gumbo Mix" :category "Condiments" :price 21.3500 :in-stock 0 }
    { :id 6 :name "Grandma's Boysenberry Spread" :category "Condiments" :price 25.0000 :in-stock 120 }
    { :id 7 :name "Uncle Bob's Organic Dried Pears" :category "Produce" :price 30.0000 :in-stock 15 }
    { :id 8 :name "Northwoods Cranberry Sauce" :category "Condiments" :price 40.0000 :in-stock 6 }
    { :id 9 :name "Mishi Kobe Niku" :category "Meat/Poultry" :price 97.0000 :in-stock 29 }
    { :id 10 :name "Ikura" :category "Seafood" :price 31.0000 :in-stock 31 }
    { :id 11 :name "Queso Cabrales" :category "Dairy Products" :price 21.0000 :in-stock 22 }
    { :id 12 :name "Queso Manchego La Pastora" :category "Dairy Products" :price 38.0000 :in-stock 86 }
    { :id 13 :name "Konbu" :category "Seafood" :price 6.0000 :in-stock 24 }
    { :id 14 :name "Tofu" :category "Produce" :price 23.2500 :in-stock 35 }
    { :id 15 :name "Genen Shouyu" :category "Condiments" :price 15.5000 :in-stock 39 }
    { :id 16 :name "Pavlova" :category "Confections" :price 17.4500 :in-stock 29 }
    { :id 17 :name "Alice Mutton" :category "Meat/Poultry" :price 39.0000 :in-stock 0 }
    { :id 18 :name "Carnarvon Tigers" :category "Seafood" :price 62.5000 :in-stock 42 }
    { :id 19 :name "Teatime Chocolate Biscuits" :category "Confections" :price 9.2000 :in-stock 25 }
    { :id 20 :name "Sir Rodney's Marmalade" :category "Confections" :price 81.0000 :in-stock 40 }
    { :id 21 :name "Sir Rodney's Scones" :category "Confections" :price 10.0000 :in-stock 3 }
    { :id 22 :name "Gustaf's Knäckebröd" :category "Grains/Cereals" :price 21.0000 :in-stock 104 }
    { :id 23 :name "Tunnbröd" :category "Grains/Cereals" :price 9.0000 :in-stock 61 }
    { :id 24 :name "Guaraná Fantástica" :category "Beverages" :price 4.5000 :in-stock 20 }
    { :id 25 :name "NuNuCa Nuß-Nougat-Creme" :category "Confections" :price 14.0000 :in-stock 76 }
    { :id 26 :name "Gumbär Gummibärchen" :category "Confections" :price 31.2300 :in-stock 15 }
    { :id 27 :name "Schoggi Schokolade" :category "Confections" :price 43.9000 :in-stock 49 }
    { :id 28 :name "Rössle Sauerkraut" :category "Produce" :price 45.6000 :in-stock 26 }
    { :id 29 :name "Thüringer Rostbratwurst" :category "Meat/Poultry" :price 123.7900 :in-stock 0 }
    { :id 30 :name "Nord-Ost Matjeshering" :category "Seafood" :price 25.8900 :in-stock 10 }
    { :id 31 :name "Gorgonzola Telino" :category "Dairy Products" :price 12.5000 :in-stock 0 }
    { :id 32 :name "Mascarpone Fabioli" :category "Dairy Products" :price 32.0000 :in-stock 9 }
    { :id 33 :name "Geitost" :category "Dairy Products" :price 2.5000 :in-stock 112 }
    { :id 34 :name "Sasquatch Ale" :category "Beverages" :price 14.0000 :in-stock 111 }
    { :id 35 :name "Steeleye Stout" :category "Beverages" :price 18.0000 :in-stock 20 }
    { :id 36 :name "Inlagd Sill" :category "Seafood" :price 19.0000 :in-stock 112 }
    { :id 37 :name "Gravad lax" :category "Seafood" :price 26.0000 :in-stock 11 }
    { :id 38 :name "Côte de Blaye" :category "Beverages" :price 263.5000 :in-stock 17 }
    { :id 39 :name "Chartreuse verte" :category "Beverages" :price 18.0000 :in-stock 69 }
    { :id 40 :name "Boston Crab Meat" :category "Seafood" :price 18.4000 :in-stock 123 }
    { :id 41 :name "Jack's New England Clam Chowder" :category "Seafood" :price 9.6500 :in-stock 85 }
    { :id 42 :name "Singaporean Hokkien Fried Mee" :category "Grains/Cereals" :price 14.0000 :in-stock 26 }
    { :id 43 :name "Ipoh Coffee" :category "Beverages" :price 46.0000 :in-stock 17 }
    { :id 44 :name "Gula Malacca" :category "Condiments" :price 19.4500 :in-stock 27 }
    { :id 45 :name "Rogede sild" :category "Seafood" :price 9.5000 :in-stock 5 }
    { :id 46 :name "Spegesild" :category "Seafood" :price 12.0000 :in-stock 95 }
    { :id 47 :name "Zaanse koeken" :category "Confections" :price 9.5000 :in-stock 36 }
    { :id 48 :name "Chocolade" :category "Confections" :price 12.7500 :in-stock 15 }
    { :id 49 :name "Maxilaku" :category "Confections" :price 20.0000 :in-stock 10 }
    { :id 50 :name "Valkoinen suklaa" :category "Confections" :price 16.2500 :in-stock 65 }
    { :id 51 :name "Manjimup Dried Apples" :category "Produce" :price 53.0000 :in-stock 20 }
    { :id 52 :name "Filo Mix" :category "Grains/Cereals" :price 7.0000 :in-stock 38 }
    { :id 53 :name "Perth Pasties" :category "Meat/Poultry" :price 32.8000 :in-stock 0 }
    { :id 54 :name "Tourtière" :category "Meat/Poultry" :price 7.4500 :in-stock 21 }
    { :id 55 :name "Pâté chinois" :category "Meat/Poultry" :price 24.0000 :in-stock 115 }
    { :id 56 :name "Gnocchi di nonna Alice" :category "Grains/Cereals" :price 38.0000 :in-stock 21 }
    { :id 57 :name "Ravioli Angelo" :category "Grains/Cereals" :price 19.5000 :in-stock 36 }
    { :id 58 :name "Escargots de Bourgogne" :category "Seafood" :price 13.2500 :in-stock 62 }
    { :id 59 :name "Raclette Courdavault" :category "Dairy Products" :price 55.0000 :in-stock 79 }
    { :id 60 :name "Camembert Pierrot" :category "Dairy Products" :price 34.0000 :in-stock 19 }
    { :id 61 :name "Sirop d'érable" :category "Condiments" :price 28.5000 :in-stock 113 }
    { :id 62 :name "Tarte au sucre" :category "Confections" :price 49.3000 :in-stock 17 }
    { :id 63 :name "Vegie-spread" :category "Condiments" :price 43.9000 :in-stock 24 }
    { :id 64 :name "Wimmers gute Semmelknödel" :category "Grains/Cereals" :price 33.2500 :in-stock 22 }
    { :id 65 :name "Louisiana Fiery Hot Pepper Sauce" :category "Condiments" :price 21.0500 :in-stock 76 }
    { :id 66 :name "Louisiana Hot Spiced Okra" :category "Condiments" :price 17.0000 :in-stock 4 }
    { :id 67 :name "Laughing Lumberjack Lager" :category "Beverages" :price 14.0000 :in-stock 52 }
    { :id 68 :name "Scottish Longbreads" :category "Confections" :price 12.5000 :in-stock 6 }
    { :id 69 :name "Gudbrandsdalsost" :category "Dairy Products" :price 36.0000 :in-stock 26 }
    { :id 70 :name "Outback Lager" :category "Beverages" :price 15.0000 :in-stock 15 }
    { :id 71 :name "Flotemysost" :category "Dairy Products" :price 21.5000 :in-stock 26 }
    { :id 72 :name "Mozzarella di Giovanni" :category "Dairy Products" :price 34.8000 :in-stock 14 }
    { :id 73 :name "Röd Kaviar" :category "Seafood" :price 15.0000 :in-stock 101 }
    { :id 74 :name "Longlife Tofu" :category "Produce" :price 10.0000 :in-stock 4 }
    { :id 75 :name "Rhönbräu Klosterbier" :category "Beverages" :price 7.7500 :in-stock 125 }
    { :id 76 :name "Lakkalikööri" :category "Beverages" :price 18.0000 :in-stock 57 }
    { :id 77 :name "Original Frankfurter grüne Soße" :category "Condiments" :price 13.0000 :in-stock 32 } ])

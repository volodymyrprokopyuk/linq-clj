(ns linq-clj.join
  (:require
    [ clojure.set :as set ]))

(defn cross-join [ products ]
  (let [ categories [ "Beverages" "Condiments" "Vegetables"
                      "Dairy Products" "Seafood" ]
         cat-set (into #{ }
                   (map #(hash-map :category %1) categories)) ]
    (for [ { :keys [ category name ] } (set/join cat-set products) ]
      [ category name ])))

(defn group-join [ products ]
  (let [ categories [ "Beverages" "Condiments" "Vegetables"
                      "Dairy Products" "Seafood" ]
         cat-set (into #{ }
                   (map #(hash-map :category %1) categories)) ]
    (group-by :category (set/join cat-set products))))

(defn outer-join [ products ]
  (let [ categories [ "Beverages" "Condiments" "Vegetables"
                      "Dairy Products" "Seafood" "XX" ]
         cat-set (into #{ }
                   (map #(hash-map :category %1) categories))
         joined-set  (set/join cat-set products)
         prod-cats (for [ { :keys [ category name ] } joined-set ]
                     [ category name ])
         empty-cats (set/difference (set categories)
                      (set (map :category joined-set))) ]
    (concat prod-cats (map #(vector %1 "No products") empty-cats))))

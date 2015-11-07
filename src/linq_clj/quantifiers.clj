(ns linq-clj.quantifiers)

(defn any-simple [ ]
  (let [ words [ "believe" "relief" "receipt" "field" ] ]
    (some #(re-find #"ei" %1) words)))

(defn any-grouped [ products ]
  (->> products (filter #(= (:in-stock %1) 0))
    (group-by :category)))

(defn all-simple [ ]
  (let [ nums [ 1 11 3 19 41 65 19 ] ]
    (every? odd? nums)))

(defn all-grouped [ products ]
  (->> products (filter #(> (:in-stock %1) 0))
    (group-by :category)))

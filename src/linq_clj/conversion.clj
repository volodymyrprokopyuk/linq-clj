(ns linq-clj.conversion)

(defn xto-array [ ]
  (let [ nums [ 1.7 2.3 1.9 4.1 2.9 ] ]
    (->> nums (sort >) (take-nth 2) vec)))

(defn xto-list [ ]
  (let [ words [ "cherry" "apple" "blueberry" ] ]
    (->> words sort (apply list))))

(defn xto-dict [ ]
  (let [ recs [ { :name "Alice" :score 50 }
                { :name "Bob" :score 40 }
                { :name "Cathy" :score 45 } ] ]
    (into { } (map (juxt :name identity) recs))))

(defn of-type [ ]
  (let [ items [ nil 1.0 "two" 3 "four" 5 "six" 7.0 ] ]
    (filter #(= (type %1) Double) items)))

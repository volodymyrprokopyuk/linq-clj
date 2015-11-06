(ns linq-clj.grouping
  (:require
    [ clj-time.core :as tm ]
    [ clojure.string :as str ]))

(defn group1 [ ]
  (let [ nums [ 5 4 1 3 9 8 6 7 2 0 ] ]
    (group-by #(rem %1 5) nums)))

(defn group2 [ ]
  (let [ words [ "blueberry" "chimpanzee" "abacus" "banana" "apple" "cheese" ] ]
    (group-by #(first %1) words)))

(defn group3 [ products ]
  (group-by :category products))

(defn nested [ customers ]
  (for [ customer customers ]
    (group-by #((juxt tm/year tm/month) (:date %1)) (:orders customer))))

(defn comparer1 [ ]
  (let [ anagrams [ "from   " " salt" " earn " "  last   " " near "
                    " form  " ] ]
    (group-by set (map str/trim anagrams))))

(defn comparer2 [ ]
  (let [ anagrams [ "from   " " salt" " earn " "  last   " " near "
                    " form  " ] ]
    (group-by set (map (comp str/upper-case str/trim) anagrams))))

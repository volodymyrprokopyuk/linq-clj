(ns linq-clj.set
  (:require
    [ clojure.set :as set ]))

(defn distinct1 [ ]
  (let [ nums [ 2 2 3 5 5 ] ]
    (distinct nums)))

(defn distinct2 [ products ]
  (->> products (map :category) distinct))

(defn union1 [ ]
  (let [ xs [ 0 2 4 5 6 8 9 ]
         ys [ 1 3 5 7 8 ] ]
    (distinct (set/union xs ys))))

(defn union2 [ products customers ]
  (let [ ps (map (comp first :name) products)
         cs (map (comp first :name) customers) ]
    (distinct (set/union ps cs))))

(defn intersect1 [ ]
  (let [ xs [ 0, 2, 4, 5, 6, 8, 9 ]
         ys [ 1, 3, 5, 7, 8 ] ]
    (set/intersection (set xs) (set ys))))

(defn intersect2 [ products customers ]
  (let [ ps (map (comp first :name) products)
         cs (map (comp first :name) customers) ]
    (set/intersection (set ps) (set cs))))

(defn except1 [ ]
  (let [ xs [ 0, 2, 4, 5, 6, 8, 9 ]
         ys [ 1, 3, 5, 7, 8 ] ]
    (set/difference (set xs) (set ys))))

(defn except2 [ products customers ]
  (let [ ps (map (comp first :name) products)
         cs (map (comp first :name) customers) ]
    (set/difference (set ps) (set cs))))

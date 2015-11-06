(ns linq-clj.core
  (:require
    [ linq-clj.data :as data ]
    [ linq-clj.restriction :as restriction ]
    [ linq-clj.projection :as projection ]
    [ linq-clj.partitioning :as partitioning ]))

(defn xtest [ ]
  ; RESTRICTION
  ;(doseq [ item (restriction/where1) ]
  ;(doseq [ item (restriction/where2 data/products) ]
  ;(doseq [ item (restriction/where3 data/products) ]
  ;(doseq [ item (restriction/drilldown data/customers) ]
  ;(doseq [ item (restriction/indexed) ]
  ; PROJECTION
  ;(doseq [ item (projection/select1) ]
  ;(doseq [ item (projection/select2 data/products) ]
  ;(doseq [ item (projection/transform) ]
  ;(doseq [ item (projection/anonymous1) ]
  ;(doseq [ item (projection/anonymous2) ]
  ;(doseq [ item (projection/anonymous3 data/products) ]
  ;(doseq [ item (projection/indexed) ]
  ;(doseq [ item (projection/filtered) ]
  ;(doseq [ item (projection/compound1) ]
  ;(doseq [ item (projection/compound2 data/customers) ]
  ;(doseq [ item (projection/compound3 data/customers) ]
  ;(doseq [ item (projection/assignment data/customers) ]
  ;(doseq [ item (projection/multiple data/customers) ]
  ;(doseq [ item (projection/indexed data/customers) ]
  ; PARTITIONING
  ;(doseq [ item (partitioning/take-simple) ]
  ;(doseq [ item (partitioning/take-nested data/customers) ]
  ;(doseq [ item (partitioning/skip-simple) ]
  ;(doseq [ item (partitioning/skip-nested data/customers) ]
  ;(doseq [ item (partitioning/take-while-simple) ]
  ;(doseq [ item (partitioning/take-while-indexed) ]
  ;(doseq [ item (partitioning/skip-while-simple) ]
  (doseq [ item (partitioning/skip-while-indexed) ]
    (println item)))

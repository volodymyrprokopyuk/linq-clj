(ns linq-clj.core
  (:require
    [ linq-clj.data :as data ]
    [ linq-clj.restriction :as restriction ]
    [ linq-clj.projection :as projection ]
    [ linq-clj.partitioning :as partitioning ]
    [ linq-clj.ordering :as ordering ]
    [ linq-clj.grouping :as grouping ]
    [ linq-clj.set :as set ]
    [ linq-clj.conversion :as conversion ]
    [ linq-clj.element :as element ]
    [ linq-clj.generation :as generation ]
    [ linq-clj.quantifiers :as quantifiers ]
    [ linq-clj.aggregate :as aggregate ]))

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
  ;(doseq [ item (partitioning/skip-while-indexed) ]
  ; ORDERING
  ;(doseq [ item (ordering/order-by1) ]
  ;(doseq [ item (ordering/order-by2) ]
  ;(doseq [ item (ordering/order-by3 data/products) ]
  ;(doseq [ item (ordering/order-by-comparer) ]
  ;(doseq [ item (ordering/order-by-desc1) ]
  ;(doseq [ item (ordering/order-by-desc2 data/products) ]
  ;(doseq [ item (ordering/order-by-desc-comparer) ]
  ;(doseq [ item (ordering/then-by) ]
  ;(doseq [ item (ordering/then-by-comparer) ]
  ;(doseq [ item (ordering/then-by-desc data/products) ]
  ;(doseq [ item (ordering/then-by-desc-comparer) ]
  ;(doseq [ item (ordering/xreverse) ]
  ; GROUPING
  ;(doseq [ item (grouping/group1) ]
  ;(doseq [ item (grouping/group2) ]
  ;(doseq [ item (grouping/group3 data/products) ]
  ;(doseq [ item (grouping/nested data/customers) ]
  ;(doseq [ item (grouping/comparer1) ]
  ;(doseq [ item (grouping/comparer2) ]
  ; SET
  ;(doseq [ item (set/distinct1) ]
  ;(doseq [ item (set/distinct2 data/products) ]
  ;(doseq [ item (set/union1) ]
  ;(doseq [ item (set/union2 data/products data/customers) ]
  ;(doseq [ item (set/intersect1) ]
  ;(doseq [ item (set/intersect2 data/products data/customers) ]
  ;(doseq [ item (set/except1) ]
  ;(doseq [ item (set/except2 data/products data/customers) ]
  ; CONVERSION
  ;(doseq [ item (conversion/xto-array) ]
  ;(doseq [ item (conversion/xto-list) ]
  ;(doseq [ item (conversion/xto-dict) ]
  ;(doseq [ item (conversion/of-type) ]
  ; ELEMENT
  ;(let [ item (element/first-simple data/products) ]
  ;(let [ item (element/first-cond) ]
  ;(let [ item  (element/first-or-default-simple) ]
  ;(let [ item  (element/first-or-default-cond data/products) ]
  ;(let [ item (element/element-at) ]
  ; GENERATION
  ;(doseq [ item (generation/xrange) ]
  ;(doseq [ item (generation/xrepeat) ]
  ; QUANTIFIERS
  ;(let [ item (quantifiers/any-simple) ]
  ;(doseq [ item (quantifiers/any-grouped data/products) ]
  ;(let [ item (quantifiers/all-simple) ]
  ;(doseq [ item (quantifiers/all-grouped data/products) ]
  ; AGGREGATE
  ;(let [ item (aggregate/count-simple) ]
  ;(let [ item (aggregate/count-cond) ]
  ;(doseq [ item (aggregate/count-nested data/customers) ]
  ;(doseq [ item (aggregate/count-grouped data/products) ]
  ;(let [ item (aggregate/sum-simple) ]
  ;(let [ item (aggregate/sum-projection) ]
  ;(doseq [ item (aggregate/sum-grouped data/products) ]
  ;(let [ item (aggregate/min-simple) ]
  ;(let [ item (aggregate/min-projection) ]
  ;(doseq [ item (aggregate/min-grouped data/products) ]
  ;(doseq [ item (aggregate/min-elements data/products) ]
  ;(let [ item (aggregate/max-simple) ]
  ;(let [ item (aggregate/max-projection) ]
  ;(doseq [ item (aggregate/max-grouped data/products) ]
  ;(doseq [ item (aggregate/max-elements data/products) ]
  ;(let [ item (aggregate/average-simple) ]
  ;(let [ item (aggregate/average-projection) ]
  ;(doseq [ item (aggregate/average-grouped data/products) ]
  ;(let [ item (aggregate/aggregate-simple) ]
  (let [ item (aggregate/aggregate-seed) ]
    (println item)))

(ns binary-tree.core-test
  (:require [clojure.test :refer :all]
            [binary-tree.core :refer :all]))

(deftest searching
  (let [empty-tree nil
        even-tree (create-tree (filter even? (range 1 11)))]
    (is (not (includes? even-tree 3)))
    (is (includes? even-tree 4))
    (is (not (includes? even-tree 12)))
    (is (not (includes? empty-tree 0)))
    (is (not (includes? empty-tree nil)))))

(deftest deleting
  (let [tree (create-tree (filter even? (range 1 11)))]
    (is (not (includes?
              (-> tree (delete 4)) 4)))))

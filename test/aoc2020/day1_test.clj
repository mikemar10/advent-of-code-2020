(ns aoc2020.day1-test
  (:require [clojure.test :refer :all]
            [aoc2020.day1 :refer :all]))

(def haystack [1721 979 366 299 675 1456])

(deftest sum-2
(testing "We find the product of 2 numbers that sum to 2020"
    (is (= 514579 (-main haystack 2)))))

(deftest sum-3
(testing "We find the product of 3 numbers that sum to 2020"
    (is (= 241861950 (-main haystack 3)))))

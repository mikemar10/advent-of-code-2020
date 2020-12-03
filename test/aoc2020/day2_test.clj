(ns aoc2020.day2-test
  (:require [clojure.test :refer :all]
            [aoc2020.day2 :refer :all]))

(def sample "1-3 a: abcde
1-3 b: cdefg
2-9 c: ccccccccc")

(deftest invalid-passwords
(testing "We find the number of valid passwords with the first policy"
    (is (= 2 (-main sample valid-password-policy-v1)))))

(deftest invalid-passwords
(testing "We find the number of valid passwords with the second policy"
    (is (= 1 (-main sample valid-password-policy-v2)))))

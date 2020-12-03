(ns aoc2020.day3-test
  (:require [clojure.test :refer :all]
            [aoc2020.day3 :refer :all]))

(def sample "..##.......
#...#...#..
.#....#..#.
..#.#...#.#
.#...##..#.
..#.##.....
.#.#.#....#
.#........#
#.##...#...
#...##....#
.#..#...#.#")

(deftest tree-hits
(testing "We find the number trees we hit on our path through the woods"
    (is (= 7 (-main sample 3 1)))))

(deftest multiple-tree-hits
  (testing "We find the product of the number of trees we would hit on several paths"
    (is (= 336 (* (-main sample 1 1)
                  (-main sample 3 1)
                  (-main sample 5 1)
                  (-main sample 7 1)
                  (-main sample 1 2))))))

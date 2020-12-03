(ns aoc2020.day3
  (:gen-class)
  (:require [clj-http.client :as http]
            [clojure.string :as str]))

(def session "CHANGEME")

(defn fetch-input [day]
   (:body (http/get (str "https://adventofcode.com/2020/day/" day "/input")
                    {:cookies {"session" {:value session}}})))

(def input (memoize fetch-input))

(defn parse-input [input]
  (str/split-lines input))

; (-main (input 3) 3 1)
; (*
; (-main (input 3) 1 1)
; (-main (input 3) 3 1)
; (-main (input 3) 5 1)
; (-main (input 3) 7 1)
; (-main (input 3) 1 2))
(defn -main [input vx vy]
  (let [world (parse-input input)
        end-of-world (count world)
        width (count (first world))]
    (loop [trees-hit 0 x 0 y 0]
      (cond
        (>= y end-of-world)
          trees-hit
        (= \# (get (world y) (mod x width)))
          (recur (inc trees-hit) (+ vx x) (+ vy y))
        :else
          (recur trees-hit (+ vx x) (+ vy y))))))

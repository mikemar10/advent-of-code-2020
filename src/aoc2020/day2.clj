(ns aoc2020.day2
  (:gen-class)
  (:require [clj-http.client :as http]
            [clojure.string :as str]))

(def session "CHANGEME")

(defn fetch-input [day]
   (:body (http/get (str "https://adventofcode.com/2020/day/" day "/input")
                    {:cookies {"session" {:value session}}})))

(def input (memoize fetch-input))

(defn parse-bounds [bounds]
  (map #(Integer/parseInt %) (str/split bounds #"-")))

(defn parse-rule [rule]
  (let [[bounds, characters, password] (str/split rule #"\s")
        [lower-bound upper-bound] (parse-bounds bounds)
        char (first characters)]
    [lower-bound upper-bound char password]))

(defn valid-password-policy-v1 [[lower-bound upper-bound char password]]
  (let [occurrences (or ((frequencies password) char) 0)]
    (<= lower-bound occurrences upper-bound)))

(defn valid-password-policy-v2 [[pos-1 pos-2 char password]]
  (let [first-char (= char (get password (dec pos-1)))
        second-char (= char (get password (dec pos-2)))]
    (and (or first-char second-char)
         (not (and first-char second-char)))))

(defn -main [input policy]
  (->> input
       str/split-lines
       (map parse-rule)
       (filter policy)
       count))

; (-main (input 2) valid-password-policy-v1)
; (-main (input 2) valid-password-policy-v2)

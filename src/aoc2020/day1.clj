(ns aoc2020.day.1
  (:gen-class)
  (:require [clj-http.client :as http]
            [clojure.string :as str]
            [clojure.math.combinatorics :as combo]))

(def session "CHANGEME")

(defn fetch-input [day]
  (map #(Integer/parseInt %) (str/split-lines
   (:body (http/get (str "https://adventofcode.com/2020/day/" day "/input")
             {:cookies {"session" {:value session}}})))))

(def input (memoize fetch-input))

(def day (-> *ns* ns-name str (str/split #"\.") last))

(defn -main [n]
  (apply * (some #(when (= 2020 (apply + %)) %)
        (combo/combinations (input day) n))))

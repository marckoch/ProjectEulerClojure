(ns projecteuler.pe017
  (:require [clojure.string :as s]))

(def numbers {1 "one"
              2 "two"
              3 "three"
              4 "four"
              5 "five"
              6 "six"
              7 "seven"
              8 "eight"
              9 "nine"
              10 "ten"
              11 "eleven"
              12 "twelve"
              13 "thirteen"
              14 "fourteen"
              15 "fifteen"
              16 "sixteen"
              17 "seventeen"
              18 "eighteen"
              19 "nineteen"
              20 "twenty"
              30 "thirty"
              40 "forty"
              50 "fifty"
              60 "sixty"
              70 "seventy"
              80 "eighty"
              90 "ninety"})

numbers

(get numbers 30)

(defn set-last-digit-zero [n]
  (* 10 (quot n 10)))

(set-last-digit-zero 51)

(defn number->british-english [n]
  (cond
    ; 1 to 19
    (<= 1 n 19) (get numbers n)
    ; exact multiples of 10 (ending on zero)
    (contains? (set (range 20 91 10)) n) (get numbers n)
    ; 21 to 99
    (< 20 n 100) (str (get numbers (set-last-digit-zero n)) "-" (get numbers (mod n 10)))
    ; all multiples of 100
    (contains? (set (range 100 901 100)) n) (str (get numbers (quot n 100)) " hundred")
    ; 101 to 999
    (< 100 n 1000) (str (get numbers (quot n 100)) " hundred and " (number->british-english (rem n 100)))
    ; 1000
    1000 "one thousand"
    :else nil))

(number->british-english 993)

(->> (range 1 1001)
     (map #(vector % (number->british-english %)))
     (into {}))

(->> (range 1 1001)
     (map number->british-english)
     (map #(s/replace % #"-" ""))
     (map #(s/replace % #" " ""))
     (map #(count %))
     (reduce +))
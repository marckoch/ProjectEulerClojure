(ns projecteuler.pe019)

(defn localdate [date]
  (java.time.LocalDate/parse date))

(defn days-from [from]
  ((fn days [day]
     (lazy-seq (cons day (days (.plusDays day 1)))))
   (localdate from)))

(defn first-of-month? [date]
  (= (.getDayOfMonth date) 1))

(defn sunday? [date]
  (= (.getDayOfWeek date) java.time.DayOfWeek/SUNDAY))

(->>
 (days-from "1901-01-01")
 (take-while #(.isBefore % (localdate "2000-12-31")))
 (filter #(and (first-of-month? %) (sunday? %)))
 count)

(comment
  (take 10 (days-from "1901-11-08"))

  (take-while #(.isBefore % (localdate "1901-01-08")) (days-from "1901-01-01")))
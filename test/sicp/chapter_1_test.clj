(ns sicp.chapter-1-test
  (:require [clojure.test :refer :all]))

(defn abs [x]
  (if (< x 0)
    (- x)
    x))

(defn average [x y]
  (/ (+ x y) 2))

(defn square [x]
  (* x x))

(defn good-enough? [current-guess last-guess]
  (< (abs (- current-guess last-guess)) 0.0001))

(defn iterative-improvements [improve x current-guess last-guess]
  (if (good-enough? current-guess last-guess)
    current-guess
    (iterative-improvements improve x (improve x current-guess) current-guess)))

(defn sqrt [x]
  (iterative-improvements #(average %2 (/ %1 %2))
                          x 1.0 0.0))

(defn cube-root [x]
  (iterative-improvements #(/ (+ (/ %1 (square %2))
                                 (* 2 %2))
                              3)
                          x 1.0 0.0))

(deftest section-1-1-exercises
  (testing "1.7"
    (is (= (int (sqrt 1)) 1))
    (is (= (int (sqrt 4)) 2))
    (is (= (int (sqrt 81)) 9))
    (is (> (sqrt 2) 1.41))
    (is (< (sqrt 2) 1.42))
    )
  (testing "1.8"
    (is (= (int (cube-root 1)) 1))
    (is (= (int (cube-root 8)) 2))
    (is (= (int (cube-root 27)) 3))
    (is (> (cube-root 2) 1.259))
    (is (< (cube-root 2) 1.26))
    )
  )

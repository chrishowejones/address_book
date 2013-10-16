(ns address_book.test.utils.number
  (:use [clojure.test]
        [address_book.utils.number]))

; This is a test clojure fixture to test the address_book.utils.number ns


(deftest test-to-keyword
  (testing "test the to-keyword function"
    (let [result (to-keyword 234)]
      (is (= result :234)))))

(deftest test-random-number
  (testing "test random-number returns a keyword"
    (let [rnd (random-number)]
      (is (keyword? rnd))))
  (testing "test that random-number returns a numeric keyword"
    (let [rnd (random-number)]
            (is (number? (read-string (name rnd)))))))

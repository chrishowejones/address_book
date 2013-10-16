(ns address_book.test.address
  (:use clojure.test
        address_book.address))

(deftest test-create
  (testing "Test create"
    (let [response (create {:name "test"})]
      (is (= (:name response) "test")))))

(deftest test-find-not-keyword
  (testing "Test find using a non keyword for the key"
    (let [found (find 1)]
      (is (= (:name found) "Siva Jagedeesan")))))

(deftest test-find-keyword
  (testing "Test find using a keyword for the key"
    (let [found (find :1)]
      (is (= (:name found) "Siva Jagedeesan")))))

(deftest test-find-all
  (testing "Test find all"
    (let [found (find-all)]
      (is (= (:name (first found)) "Siva Jagedeesan"))
      (is (= (:id (first found)) :1))
      (is (= (:street1 (first found)) "88 7th")))))

(deftest test-update
  (testing "Test update"
    (let [updated-attrs (update :1 {:city "Cambridge"})]
; as the update is changing state I update an attribute I don't check in the other tests so I don't need to reset the update
      (is (= (:city updated-attrs) "Cambridge"))
      (is (= (:id updated-attrs) :1)))))

(deftest test-delete
  (testing "Test delete"
    (let [deleted-attrs (delete :1)]
      (is (= (:name deleted-attrs) "Siva Jagedeesan"))
      (is (= (:id  deleted-attrs) :1)))))

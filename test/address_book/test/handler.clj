(ns address_book.test.handler
  (:use clojure.test
        ring.mock.request
        address_book.handler))

(deftest test-app
  (testing "main route"
    (let [response (app (request :get "/addresses"))]
      (is (= (:status response) 200))))

  (testing "not-found route"
    (let [response (app (request :get "/invalid"))]
      (is (= (:status response) 404)))))

(deftest resources
  (testing "resources"
    (let [response (app (request :get "/index.html"))]
      (is (= (:status response) 200))
      (is (.getName (:body response)) "index.html"))))

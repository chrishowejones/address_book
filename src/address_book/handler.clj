(ns address_book.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [address_book.address :as address]
            [clj-json.core :as json]))

(defn json-response [data & [status]]
  {:status (or status 200)
   :headers {"Content-type" "application/json"}
   :body (json/generate-string data)})

(defroutes app-routes
  (GET "/addresses" [] (json-response(address/find-all)))
  (GET "/addresses/:id" [id] (json-response(address/find id)))
  (POST "/addresses" {params :params} (json-response(address/create params)))
  (route/files "/" {:root "resources/public"})
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

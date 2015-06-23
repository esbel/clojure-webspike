(ns spike.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler] [hiccup.core :as h]))

(defn- str-to [num]
  (apply str (interpose ", " (range 1 (inc num)))))

(defn- str-from [num]
  (apply str (interpose ", " (reverse (range 1 (inc num))))))

(defn- upload-template []
  (h/html
    [:h1 "Hello Word"]
    [:h2 "Select marketing data to upload"]
  ))

(defroutes app
  (GET "/count-up/:to" [to] (str-to (Integer. to)))
  (GET "/count-down/:from" [from] (str-from (Integer. from)))
  (GET "/upload" [] (upload-template))
)

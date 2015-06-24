; project.clj
(defproject spike "0.1.0-SNAPSHOT"

  :plugins [[lein-ring "0.8.10"]]

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/java.jdbc "0.3.2"]
                 [org.clojure/clojure-contrib "1.2.0"]
                 [postgresql "9.1-901.jdbc4"]
                 [ring/ring-jetty-adapter "1.2.1"]
                 [hiccup "1.0.4"]
                 [compojure "1.1.6"]
                 [dk.ative/docjure "1.8.0"]]

  :ring {:handler spike.handler/app
         :nrepl {:start? true
                 :port 9998}}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})


; https://github.com/mjul/docjure
; https://devcenter.heroku.com/articles/clojure-web-application
; https://github.com/remodoy/clj-postgresql
; file upload https://gist.github.com/nikolaplejic/562624

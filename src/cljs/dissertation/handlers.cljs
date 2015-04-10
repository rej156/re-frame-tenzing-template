(ns dissertation.handlers
  (:require [re-frame.core :refer [dispatch register-handler path trim-v after]]))

(register-handler
 :render-component
 [trim-v]
 (fn [db [component]]
   (assoc db :component component)))

(register-handler
 :initialise-db
 (fn [db [_]]
   {:component :home}))

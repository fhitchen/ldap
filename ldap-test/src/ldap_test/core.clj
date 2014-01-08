(ns ldap-test.core
  (:require [clj-ldap.client :as ldap]))

(def ldap-server (ldap/connect {:host "x500.bund.de"}))

(ldap/get ldap-server "cn=Schiffbauer,o=Bund,c=DE")

(def ldap-server2 (ldap/connect {:host "ldap.virginia.edu"}))

(ldap/search! ldap-server2 "o=University of Virginia,c=US"
             {:filter "sn=michael*"}
              (fn [x]
                (println "Hello " (:eduPersonOrgUnitDN x))))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

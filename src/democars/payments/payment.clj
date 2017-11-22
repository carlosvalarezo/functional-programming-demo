(ns democars.payments.payment)

(defn calculateTotalPayment [subtotal discount insurance]
  (+ subtotal discount insurance))

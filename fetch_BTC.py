import csv
import time as timer
import requests
import json
last_price=0
last_vol=0
last_time=0
for i in range(1440):
    f = open('//toaster/homes/a/r/arnav1993k/nt/AccountSettings/Desktop/BTC.csv', 'a',newline='')
    w = csv.writer(f)
    r = requests.get("https://apiv2.bitcoinaverage.com/indices/global/ticker/BTCUSD")
    t=json.loads(r.text)
    price=t['last']
    vol=t['volume']
    time=t['timestamp']
    del_p=price-last_price
    del_v=vol-last_vol
    del_time=time-last_time
    row=[price,vol,time,del_p,del_v,del_time]
    w.writerow(row)
    last_price=price
    last_vol=vol
    last_time=time
    f.close()
    timer.sleep(60)
    

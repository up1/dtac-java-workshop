# Parking
ระบบการจองที่จอดรถ

## GET /parking_lot/available
ดึงข้อมูลที่จอดรถในแต่ละชั้น

===
### Success response

* Status: 200

```json
[
  {
     "floor": 1,
     "parking": {
        "total": 20,
        "available": 10
     }
  },
  {
     "floor": 2,
     "parking": {
        "total": 30,
        "available": 50
     }
  },
  {
     "floor": 3,
     "parking": {
        "total": 10,
        "available": 5
     }
  },
  {
     "floor": 4,
     "parking": {
        "total": 50,
        "available": 50
     }
  }
]
```

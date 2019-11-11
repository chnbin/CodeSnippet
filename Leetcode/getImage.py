import requests

id = 12
page = 1
for i in range(200):
  image_url = "http://img.177pic.info/uploads/2014/03g/0" + str(id) + ".jpg"
  print(image_url + "downloading..")
  img_data = requests.get(image_url).content
  with open('image_name'+page+'.jpg', 'wb') as handler:
    handler.write(img_data)
  id = id + 10
  page = page + 1
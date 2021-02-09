#-*- coding: utf-8 -*- 
import requests
from bs4 import BeautifulSoup
url = 'https://movie.naver.com/movie/sdb/rank/rmovie.nhn'
response= requests.get(url)
source = response.text

soup = BeautifulSoup(source, 'html.parser')

top_list = soup.findAll('div',{"class":"tit3"}) 

rank = 1
for i in top_list:
	print(rank, i.text.strip())
	rank = rank+1

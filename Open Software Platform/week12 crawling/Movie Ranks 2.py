import requests
from bs4 import BeautifulSoup

url ='https://www.imdb.com/chart/boxoffice?pf_rd_m=A2FGELUUNOQJNL&pf_rd_p=4da9d9a5-d299-43f2-9c53-f0efa18182cd&pf_rd_r=QNEDH1MZW3WHA9ET12Y5&pf_rd_s=right-4&pf_rd_t=15506&pf_rd_i=boxoffice&ref_=chtbo_ql_1'
response= requests.get(url)
source = response.text

soup = BeautifulSoup(source, 'html.parser')

top_list = soup.findAll('td',{"class":"titleColumn"}) 

rank = 1
for i in top_list:
    print (rank, i.text.strip())
    link = i.a.get('href')
    movie_url = 'https://www.imdb.com'+link
    print(movie_url,"\n")
    rank+=1

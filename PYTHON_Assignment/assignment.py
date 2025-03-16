import requests
from bs4 import BeautifulSoup
import pandas as pd
from sqlalchemy import create_engine

# 1. The Target Website
URL = 'https://www.coursera.org/in/articles/what-is-python-used-for-a-beginners-guide-to-using-python'

# 2. Write Scraping Script
def scrape_website(url):
    try:
        response = requests.get(url)
        response.raise_for_status()
        soup = BeautifulSoup(response.text, 'html.parser')
        text = soup.get_text()
        return text
    except requests.exceptions.RequestException as e:
        print(f"Error fetching data: {e}")
        return None

# 3. SEO Analysis - Get Word Count
def analyze_seo(text):
    words = text.split()
    ignore_words = ['of', 'me', 'my', 'myself', 'we', 'our', 'ours', 
'ourselves', 'you', "you're", "you've", "you'll", "you'd", 'your', 'yours', 'yourself', 
'yourselves', 'he', 'him', 'his', 'himself', 'she', "she's", 'her', 'hers', 'herself', 
'it', "it's", 'its', 'itself', 'they', 'them', 'their', 'theirs', 'themselves',
 'what', 'which', 'who', 'whom', 'this', 'that', "that'll", 'these', 'those', 'am', 'is', 'are',
 'was', 'were', 'be', 'been', 'being', 'have', 'has', 'had', 'having', 'do', 'does', 'did', 'doing',
 'a', 'an', 'the', 'and', 'but', 'if', 'or', 'because', 'as', 'until', 'while', 'of', 'at', 'by', 'for', 
'with', 'about', 'against', 'between', 'into', 'through', 'during', 'before', 'after', 'above', 'below', 'to', 
'from', 'up', 'down', 'in', 'out', 'on', 'off', 'over', 'under', 'again', 'further', 'then', 'once', 
'here', 'there', 'when', 'where', 'why', 'how', 'all', 'any', 'both', 'each', 'few', 'more', 'most', 
'other', 'some', 'such', 'no', 'nor', 'not', 'only', 'own', 'same', 'so', 'than', 'too', 'very', 
 'can', 'will', 'just', 'don', "don't", 'should', "should've", 'now', 
 'ain', 'aren', "aren't", 'couldn', "couldn't", 'didn', "didn't", 'doesn', "doesn't", 
'hadn', "hadn't", 'hasn', "hasn't", 'haven', "haven't", 'isn', "isn't", 'ma', 'mightn',
 "mightn't", 'mustn', "mustn't", 'needn', "needn't", 'shan', "shan't", 'shouldn', "shouldn't", 
'wasn', "wasn't", 'weren', "weren't", 'won', "won't", 'wouldn', "wouldn't"]
    word_count={}
    for word in words:
        if word not in ignore_words:
            if word not in word_count:
                word_count[word]=1
            else:
                word_count[word]+=1
    word_count = {key: val for key, val in sorted(word_count.items(), key = lambda ele: ele[1], reverse = True)}
    return dict(word_count)

# 4. Save to CSV and SQL
def save_data(word_count):

    df = pd.DataFrame(list(word_count.items()), columns=['Word', 'Count'])
    df.to_csv('seo_analysis.csv', index=False)
    print("Data saved to 'seo_analysis.csv'")

    # Save to SQLite database
    engine = create_engine('sqlite:///seo_analysis.db')
    df.to_sql('seo_data', con=engine, if_exists='replace', index=False)
    print("Data saved to 'seo_analysis.db'")

# 5. Test Script
def main():
    print("Scraping website...")
    data = scrape_website(URL)
    if data:
        print("Analyzing data...")
        word_count = analyze_seo(data)
        print("Saving data...")
        save_data(word_count)
        print("SEO Analysis Completed Successfully")

if __name__ == "__main__":
    main()
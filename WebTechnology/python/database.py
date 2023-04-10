from databases import Database
from model import Item
database = Database('mysql+aiomysql:///root:@localhost:3306/classwork')

async def connect_db():
    await database.connect()
    
# async def seedetails():
#     query = "select * from shoppingitem"
    
# async def insert(item : Item):
#     query = "insert into shoppingitem(name, price) values(:name, :price)"
#     #values = {"name": "apple", "price": 1.99}
#     values = {"name": item.name, "price": item.price}
#     await database.execute(query=query, values=values)
    

query = """CREATE TABLE HighScores (id INTEGER PRIMARY KEY, name VARCHAR(100), score INTEGER)"""
async def create_table():
    await database.execute(query=query)

# Insert some data.
query = "INSERT INTO HighScores(name, score) VALUES (:name, :score)"
values = [
    {"name": "Daisy", "score": 92},
    {"name": "Neil", "score": 87},
    {"name": "Carol", "score": 43},
]

async def insert_data():
    await database.execute_many(query=query, values=values)

# Run a database query.
query = "SELECT * FROM HighScores"

async def fetch_data():
    rows = await database.fetch_all(query=query)
    print('High Scores:', rows)
from fastapi import FastAPI
from model import Item
from database import *

app = FastAPI()
app.on_event("startup")
async def connect_with_database():
    connect_db()


@app.get("/")
async def root():
    return {"message": "Hello World"}

# @app.get("/bool", response_model=bool)
# async def bool():
#     return True

# @app.get("/{id}")
# async def int(id: int):
#     return {"id": id}

# @app.get("/items/{item_id}")
# async def read_item(item_id):
#     return {"item_id": item_id}

# @app.get("/items/")
# async def read_item():
#     return await seedetails()

# @app.post("/item/", response_model=Item)
# async def post_item(item: Item):
#     await insert(item)
#     return item

@app.post("/highscores/")
async def post_highscores():
    await create_table()
    await insert_data()
    await fetch_data()


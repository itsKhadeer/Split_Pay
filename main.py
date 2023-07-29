from fastapi import FastAPI
import models
from database import engine
from router import user

app = FastAPI()

models.Base.metadata.create_all(engine)



app.include_router(user.router)


# def get_db():
#    db = SessionLocal()
#    try:
#        yield db
#    finally:
#        db.close()


# @app.get("/")
# async def index():
#     return "hello world"


# @app.get("/users")
# async def get_users(db:Session = Depends(get_db)):
#     users = db.query(models.The_User).all()#.filter(models.Blog.id == id).first()
#     return users
    


# @app.post("/signup")
# async def signup(request: schemas.signup_user, db: Session = Depends(get_db)):
#     new_user = models.The_User(username=request.username, password=Hash.bcrypt(request.password), email=request.email)
#     db.add(new_user)
#     db.commit()
#     db.refresh(new_user)




# @app.post("/delete_user")
# async def delete_user(userID: int ,db:Session = Depends(get_db)):

#     dict_to_return = {"userID": userID,
#             "UserName": db.query(models.The_User).get(userID),
#             "deleted": True}
    
#     user_to_delete = db.query(models.The_User).filter(models.The_User.userid == userID).delete(synchronize_session=False)

#     db.commit()
    
#     return(dict_to_return)



# @app.put("/update-user/")
# async def update(request: schemas.update_user, db:Session = Depends(get_db)):
#     if request.username:
#         dict_to_return = {"userID": request.userId,
#             "UserName": db.query(models.The_User).get(request.userId),
#             "updated": True}
        
#         db.query(models.The_User).filter(models.The_User.userid == request.userId).update({"username":request.username})
#         db.commit()


#     if request.email:
#         dict_to_return = {"userID": request.userId,
#             "UserName": db.query(models.The_User).get(request.userId),
#             "updated": True}
        
#         db.query(models.The_User).filter(models.The_User.userid == request.userId).update({"email":request.email})
#         db.commit()

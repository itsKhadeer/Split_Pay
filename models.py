from sqlalchemy import Column, Integer, String, BOOLEAN
from sqlalchemy.orm import relationship
from database import Base



class The_Splits(Base):
    __tablename__ = "splits"

    splitid = Column(Integer, primary_key=True, index=True, autoincrement=True)
    split_name = Column(String)
    money_tosplit = Column(Integer)
    reciever_userid = Column(Integer)
    givers = Column(String, default="")
    users_settled = Column(String, default="")
    settled = Column(BOOLEAN, default=False)
    




class The_User(Base):
    
    __tablename__ = "users"

    userid = Column(Integer, primary_key=True, index=True, autoincrement=True)
    username=Column(String)
    email=Column(String)
    password=Column(String) 
    money_lent = Column(Integer)
    money_owes = Column(Integer)

    lent_splits_id = Column(String, default="")
    owes_splits_id = Column(String, default="")

class The_Transactions(Base):
    __tablename__ = "transactions"

    transactionid = Column(Integer, primary_key=True, index=True, autoincrement=True)
    reciever_userid = Column(Integer)
    sender_userid = Column(Integer)
    amount_transfered = Column(Integer)



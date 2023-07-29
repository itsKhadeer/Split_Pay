from passlib.context import CryptContext
import jwt
from dotenv import dotenv_values
from models import The_User
from fastapi.exceptions import HTTPException
from fastapi import status

pwd_cxt = CryptContext(schemes=["bcrypt"], deprecated="auto")

config_credential = dotenv_values(".env")

class Hash():
    def bcrypt(password: str):
        return pwd_cxt.hash(password)
    
    def verify (hashed_password, plain_password):
        return pwd_cxt.verify( plain_password, hashed_password)
    



from pydantic import BaseModel,EmailStr

from typing import Union, List

class signup_user_req(BaseModel):
    username: str
    email:  EmailStr
    password: str
    
class update_user(BaseModel):
    userId: int
    username: Union[str, None] = None
    email: Union[EmailStr, None] = None

class login_user_req(BaseModel):
    email: EmailStr
    password: str

class login_user_res(BaseModel):
    userid: int
    username: str
    email: EmailStr
    photo: Union[str, None] = None


class split_req(BaseModel):
    split_name: str
    givers: List[int]
    receiver_userid: int
    money_tosplit: int

class settle_req(BaseModel):
    giver_userid: int
    reciever_userid: int
    splitid: int
    



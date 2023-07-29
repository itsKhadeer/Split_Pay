from fastapi import Depends, HTTPException, status
import JWT_token

oauth2_scheme = oAuth2PasswordBearer(tokenUrl="login")

async def get_current_user(JWT_token: str = Depends(oauth2_scheme)):
    credentials_exception = HTTPException(
        status_code=status.HTTP_401_UNAUTHORIZED,
        detail="Could not validate credentials",
        headers={"WWW-Authenticate": "Bearer"},
    )

    return JWT_token.verify_token(JWT_token, credentials_exception)
    
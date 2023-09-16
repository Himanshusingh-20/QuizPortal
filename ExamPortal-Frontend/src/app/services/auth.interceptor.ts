import { Injectable } from '@angular/core';
import { HTTP_INTERCEPTORS, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Observable } from "rxjs";
import { LoginService } from './login.service';

const TOKEN_HEADER = 'Authorization';

@Injectable()
export class AuthInterceptor implements HttpInterceptor{

  constructor(private login:LoginService){}

  intercept(req:HttpRequest<any>,next:HttpHandler):Observable<HttpEvent<any>>{
    let authReq = req
    const token = this.login.getToken();
    console.log("inside interceptor")
    if(token != null)
    {
      authReq = authReq.clone({setHeaders:{Authorization:`Bearer ${token}`}});
    }
    return next.handle(authReq);
  }
}

export const AuthInterceptorProviders = [
  {
    provide : HTTP_INTERCEPTORS,
    useClass : AuthInterceptor,
    multi : true
  }
]

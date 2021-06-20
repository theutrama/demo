import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Post} from "./post";


@Injectable({
  providedIn: 'root'
})
export class PostService {

  private serviceUrl = "http://localhost:8080/api/v1/post";

  constructor(private http: HttpClient) { }

  public getPosts()/*: Observable<Post[]>*/{
    //let response = this.http.get<Post[]>(this.serviceUrl);
    //response.forEach((post) => console.log(post))
    return this.http.get<Post[]>(this.serviceUrl).pipe();
  }

}

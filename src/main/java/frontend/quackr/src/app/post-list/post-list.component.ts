import {Component, OnInit, ViewChild} from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {MatTableDataSource } from "@angular/material/table";
import {PostService} from "../../post.service";
import {Observable} from "rxjs";
import {DataSource} from "@angular/cdk/collections";
import {Post} from "../../post";
import {MatTable} from "@angular/material/table";
import {MatSort} from "@angular/material/sort";
import {MatTableModule} from "@angular/material/table";
import {MatFormFieldModule} from '@angular/material/form-field';


@Component({
  selector: 'app-post-list',
  templateUrl: './post-list.component.html',
  styleUrls: ['./post-list.component.sass']
})
export class PostListComponent implements OnInit {

  posts:any;
  users:any;



  //dataSource = new PostDataSource(this.postService);

  ELEMENT_DATA : Post[] = [];
  displayedColumns = ["postId", "creationDate", "content", "user"]
  dataSource: MatTableDataSource<Post> = new MatTableDataSource<Post>(this.ELEMENT_DATA);

  constructor(private postService: PostService,private http: HttpClient) {

  }


  ngOnInit() {
    this.getAllPosts();
  }

  public getAllPosts(){
    let response = this.postService.getPosts();
    response.subscribe(data => this.dataSource.data = data as Post[]);
  }

  applyFilter(filterValue: string){
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
}

export class PostDataSource extends DataSource<any>{
  constructor(private postService: PostService) {
    super();
  }

  connect(): Observable<Post[]> {
    return this.postService.getPosts();
  }

  disconnect() {
  }

}


import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CreatePostComponent} from "./create-post/create-post.component";
import {PostDetailsComponent} from "./post-details/post-details.component";
import {PostListComponent} from "./post-list/post-list.component";

const routes: Routes = [
  {path:"", pathMatch: "full", redirectTo: "/"},
  {path:"create-post", component: CreatePostComponent},
  {path:"post-details", component: PostDetailsComponent},
  {path:"post-list", component: PostListComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

export interface Post {
  postId: number,
  creationDate: string,
  content: string;
  user: {
    userId: number;
    first_name: string;
    last_name: string;
    email: string;
    username: string;
  }
}

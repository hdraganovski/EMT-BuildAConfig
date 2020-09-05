export interface UserDto {
  id: string;
  email: string;
  fullName: string;
  imageUrl: string;
  cart: CartDto;
  purchases: PurchaseDto[];
  configurations: ConfigurationDto[];
}

export interface CartDto {
  id: string;
  products: ProductDto[];
  totalPrice: number;
}

export interface PurchaseDto {
  id: string;
  cart: CartDto;
}

export interface ConfigurationDto {
  id: string;
  products: string[];
  upvotes: number;
  comments: CommentDto[];
}

export interface ProductDto {
  id: string;
  title: string;
  description: string;
  imageUrls: string[];
  price: number;
  stock: number;
  type: string;
  reviews: ReviewDto[];
}

export interface CommentDto {
  id: string;
  body: string;
  user: UserReview;
  comments: CommentDto[];
  upvotes: number;
}

export interface UserReview {
    id: string,
    fullName: string,
    imageUrl: string
}

export interface Messagee {
  message: string;
}

export interface ReviewDto {
  id: string;
  userReview: UserReview;
  body: string;
  stars: number;
  upvotes: number;
}

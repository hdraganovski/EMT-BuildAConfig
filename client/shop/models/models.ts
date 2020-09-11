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
  id: string;
  fullName: string;
  imageUrl: string;
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

export interface Notificaton {
  message: string;
  color: string;
}

export interface CategoryDto {
  id: string;
  name: string;
  imageUrl: string;
}

export interface Page<T> {
  content: T[];
  pageable: Pagable;
  totalElements: number;
  totalPages: number;
  last: boolean;
  number: number;
  size: number;
  sort: Sort;
  numberOfElements: number;
  first: boolean;
  empty: boolean;
}

export interface Pagable {
  sort: Sort;
  offset: number;
  pageSize: number;
  pageNumber: number;
  paged: boolean;
  unpaged: boolean;
}

export interface Sort {
  sorted: boolean;
  unsorted: boolean;
  empty: boolean;
}

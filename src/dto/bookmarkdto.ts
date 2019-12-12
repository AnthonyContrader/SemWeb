import { TopicDTO } from './topicdto';
import { UserDTO } from './userdto';

export class BookmarkDTO {

    id: number;

    bookmarkName: string;

    topicDTO: TopicDTO;

    userDTO: UserDTO;
}
import {UserDTO} from './userdto';
import {TopicDTO} from './topicdto';

export class BookmarkDTO {

    id : number;
    bookmarkName : string;
    userDTO : UserDTO;
    topicDTO : TopicDTO;
}

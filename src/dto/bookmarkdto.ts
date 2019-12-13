import {UserDTO} from './userdto';
import {TopicDTO} from './topicdto';

export class BookmarkDTO {

    id : number;
    bookmarkname : string;
    userid : UserDTO;
    topicid : TopicDTO;
}

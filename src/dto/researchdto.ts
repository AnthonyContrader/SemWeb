import { UserDTO } from './userdto';
import { TopicDTO } from './topicdto'; 

export class ResearchDTO {

    id: number;

    date: Date;

    userDTO: UserDTO;

    topicDTO: TopicDTO;

}